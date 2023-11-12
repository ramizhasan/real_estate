package com.prettier;

import com.prettier.entity.concretes.Role;
import com.prettier.entity.concretes.User;
import com.prettier.entity.enums.RoleType;
import com.prettier.repository.RoleRepository;
import com.prettier.repository.UserRepository;
import jakarta.transaction.Transactional;
import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;
import java.util.*;

@SpringBootApplication
@RequiredArgsConstructor
@EnableJpaAuditing  //kayit oncesi time stamp almak icin eklenildi
public class RealEstateApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(RealEstateApplication.class, args);
    }

    @Override

    public void run(String... args) throws Exception {


//creating Roles ----------------------------------------------------------------
        Role admin = Role.builder()
                .roleType(RoleType.ADMIN).build();
        Role manager = Role.builder()
                .roleType(RoleType.MANAGER).build();
        Role customer = Role.builder()
                .roleType(RoleType.CUSTOMER).build();
//filling the role entity ---------------------------------------------------------
        roleRepository.save(admin);
        roleRepository.save(manager);
        roleRepository.save(customer);
// Creating user ----------------------------------------------------------------
        User ramiz = User.builder()
                .firstName("Ramiz")
                .lastName("Hasan")
                .email("aaabbbdddd@ccc.com")
                .phone("0555555501")
                .passwordHash("93486249587ytfhhebdkjhv")
                .roleSet(Set.of(admin, manager))
                .build();
        //.createAte(LocalDateTime.now()) // otomatik olarak yapilacak;

        User akin = User.builder()
                .firstName("Akin")
                .lastName("Toprak")
                .email("bbbcccdddd@ccc.com")
                .phone("0555555502")
                .passwordHash("93486249587ytfhhebdkjhv")
                .roleSet(Set.of(manager, customer))
                .build();
        //.createAte(LocalDateTime.now()) // otomatik olarak yapilacak;

        User ahmet = User.builder()
                .firstName("Ahmet")
                .lastName("Saat")
                .email("cccdddeee@ccc.com")
                .phone("0555555503")
                .passwordHash("93486249587ytfhhebdkjhv")
                .roleSet(Set.of(customer))
                .build();

        User mert = User.builder()
                .firstName("Mert")
                .lastName("Karabulut")
                .email("dddeeefff@ccc.com")
                .phone("0555555504")
                .passwordHash("93486249587ytfhhebdkjhv")
                .roleSet(Set.of(manager, customer))
                .build();
        userRepository.save(ramiz);
        userRepository.save(akin);
        userRepository.save(ahmet);
        userRepository.save(mert);


        for (Iterator<User> it = findUserSetById(2L); it.hasNext(); ) {
            User u = it.next();
            System.out.println(u.toString());

        }

    }

// Method to get LAZY  userSet from RoleRepository and Returns iterator.
    @Transactional
    public Iterator<User> findUserSetById(Long id){
        Role role = roleRepository.findById(2L).orElseThrow();
        Set<User> userSet = role.getUserSet();
        return userSet.iterator();
    }
}


