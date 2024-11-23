package com.example.demo.model.dto;

import com.example.demo.model.entity.AppUser;

import java.util.List;
import java.util.stream.Collectors;

public class UserDto {
    private long id;
    private String username;
    private List<RoleDto> roleDtoList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<RoleDto> getRoleDtoList() {
        return roleDtoList;
    }

    public void setRoleDtoList(List<RoleDto> roleDtoList) {
        this.roleDtoList = roleDtoList;
    }

    public static UserDto map(AppUser user) {
        if (user == null) {
            return null;
        }
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRoleDtoList(user.getRoles().stream().map(RoleDto::map).collect(Collectors.toList()));
        return dto;
    }
}
