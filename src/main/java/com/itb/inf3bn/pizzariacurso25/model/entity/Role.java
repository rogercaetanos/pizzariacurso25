package com.itb.inf3bn.pizzariacurso25.model.entity;

import static com.itb.inf3bn.pizzariacurso25.model.entity.Permission.*;

import java.util.Set;;

public enum Role {

    ADMIN(
        Set.of(
            ADMIN_READ,
            ADMIN_UPDATE,
            ADMIN_CREATE,
            ADMIN_DELETE,
            FUNCIONARIO_READ,
            FUNCIONARIO_UPDATE,
            FUNCIONARIO_CREATE,
            FUNCIONARIO_DELETE
        )
    ),
    CLIENTE(
       Set.of(
            CLIENTE_READ,
            CLIENTE_UPDATE,
            CLIENTE_CREATE,
            CLIENTE_DELETE
       )

    ),
    FUNCIONARIO(
 Set.of(
            FUNCIONARIO_READ,
            FUNCIONARIO_UPDATE,
            FUNCIONARIO_CREATE,
            FUNCIONARIO_DELETE
       )
    
    );


    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    


}
