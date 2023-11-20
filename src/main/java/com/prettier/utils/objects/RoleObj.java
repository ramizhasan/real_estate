package com.prettier.utils.objects;

import com.prettier.entity.concretes.Role;
import com.prettier.entity.enums.RoleType;
import com.prettier.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class RoleObj {

    private final RoleRepository roleRepository;

    //Role Creators and returners
    public Role getAdmin() { return  Role.builder().roleType(RoleType.ADMIN).build();}
    public Role getManager() { return  Role.builder().roleType(RoleType.MANAGER).build();}
    public Role getCustomer() { return  Role.builder().roleType(RoleType.CUSTOMER).build();}

    // Role Savers to the repository
    public Role saveRoleToRoleRepository(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> fillRoleRepository(){
         return roleRepository.saveAll(Set.of(getAdmin(), getManager(), getCustomer()));
    }
}
