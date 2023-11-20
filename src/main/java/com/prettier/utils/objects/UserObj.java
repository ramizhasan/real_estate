package com.prettier.utils.objects;

import com.prettier.entity.concretes.Role;
import com.prettier.entity.concretes.User;
import com.prettier.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserObj  {

    private final UserRepository userRepository;
    private final RoleObj roleObj;


    /**
     * createAndReturnUser
     * @return User without roleSet(), advertSet(), built_in(), logSet(), tourRequestSetForGuest()
     */
    public User createAndReturnRamiz(){
        return User.builder().firstName("Ramiz").lastName("Hasan").email("aaabbbdddd@ccc.com").phone("0555555501").passwordHash("93486249587ytfhhebdkjhv").build();
    }public User createAndReturnAkin(){
        return  User.builder().firstName("Akin").lastName("Toprak").email("bbbcccdddd@ccc.com").phone("0555555502").passwordHash("93486249587ytfhhebdkjhv").build();
    }public User createAndReturnAhmet(){
        return User.builder().firstName("Ahmet").lastName("Saat").email("cccdddeee@ccc.com").phone("0555555503").passwordHash("93486249587ytfhhebdkjhv").build();
    }public User createAndReturnMert(){
        return User.builder().firstName("Mert").lastName("Karabulut").email("dddeeefff@ccc.com").phone("0555555504").passwordHash("93486249587ytfhhebdkjhv").build();
    }

    public User saveUserToRepository (User user) {
        return   userRepository.save(user);
    }

    /**
     * @param :  is an demo saver it saves four created user into the repository. but they are not full acoording to column
     * @return list of user that saved in repository
     */
    public List<User> fillUserRepository() {
        return userRepository.saveAll(Set.of(createAndReturnRamiz(),createAndReturnAkin(),createAndReturnAhmet(),createAndReturnMert()));
    }
//    // Method to get LAZY  userSet from RoleRepository and Returns iterator.
//    @Transactional
//    public Iterator<User> findUserSetById(Long id){
//        Role role = roleRepository.findById(id).orElseThrow();
//        Set<User> userSet = role.getUserSet();
//        return userSet.iterator();
//    }
//    @Transactional
//    public void print() {
//
//        for (Iterator<User> it = findUserSetById(2L); it.hasNext(); ) {
//            User u = it.next();
//            System.out.println(u.toString());
//        }
//    }

}
