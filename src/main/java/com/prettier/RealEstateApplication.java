package com.prettier;

import com.prettier.entity.concretes.*;
import com.prettier.entity.enums.RoleType;
import com.prettier.repository.*;
import com.prettier.utils.objects.AdvertObj;
import com.prettier.utils.objects.AdvertTypeObj;
import com.prettier.utils.objects.RoleObj;
import com.prettier.utils.objects.UserObj;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.*;

@SpringBootApplication
@RequiredArgsConstructor
@EnableJpaAuditing  //kayit oncesi time stamp almak icin eklenildi
public class RealEstateApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserObj userObj;
    private final AdvertTypeObj advertTypeObj;
    private final RoleObj roleObj;
    private final AdvertObj advertObj;
    private final AdvertTypeRepository advertTypeRepository;
    private final AdvertRepository advertRepository;
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final DistrictRepository districtRepository;
    private final CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(RealEstateApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        //advertTypeObj.fillAdvertTypeRepository();
        AdvertType housing = advertTypeObj.createHousing();
        advertTypeRepository.save(housing);

        Advert advertAnkara = advertObj.createAdvertAnkara();
        advertAnkara.setAdvertType(housing);

        Country turkiye = Country.builder().name("Turkiye").build();
        countryRepository.save(turkiye);
        City ankara = City.builder().name("Ankara").build();
        ankara.setCountry(turkiye);
        cityRepository.save(ankara);
        District cankaya = District.builder().name("Cankaya").build();
        cankaya.setCity(ankara);
        districtRepository.save(cankaya);
        User andReturnAhmet = userObj.createAndReturnAhmet();
        userRepository.save(andReturnAhmet);


        Category satilik = Category.builder().title("villa").seq(2).slug("satilik-temiz").icon("iconcan").build();
        CategoryPropertyKey key1 = CategoryPropertyKey.builder().category(satilik).name("Key1").build();
        CategoryPropertyKey key2 = CategoryPropertyKey.builder().category(satilik).name("Key2").build();
        CategoryPropertyKey key3 = CategoryPropertyKey.builder().category(satilik).name("Key3").build();

        CategoryPropertyValue value1 = CategoryPropertyValue.builder().value("value1").categoryPropertyKey(key1).advert(advertAnkara).build();
        CategoryPropertyValue value2 = CategoryPropertyValue.builder().value("value2").categoryPropertyKey(key1).advert(advertAnkara).build();
        CategoryPropertyValue value3 = CategoryPropertyValue.builder().value("value3").categoryPropertyKey(key1).advert(advertAnkara).build();
        CategoryPropertyValue value4 = CategoryPropertyValue.builder().value("value4").categoryPropertyKey(key1).advert(advertAnkara).build();
        CategoryPropertyValue value5 = CategoryPropertyValue.builder().value("value5").categoryPropertyKey(key1).advert(advertAnkara).build();
        CategoryPropertyValue value6 = CategoryPropertyValue.builder().value("value6").categoryPropertyKey(key1).advert(advertAnkara).build();
        CategoryPropertyValue value7 = CategoryPropertyValue.builder().value("value7").categoryPropertyKey(key1).advert(advertAnkara).build();
        categoryRepository.save(satilik);



        advertAnkara.setCountry(turkiye);
        advertAnkara.setCity(ankara);
        advertAnkara.setDistrict(cankaya);
        advertAnkara.setUser(andReturnAhmet);
        advertAnkara.setCategory(satilik);


        advertRepository.save(advertAnkara);


//*--------------------------ADVERT IZMIR---------------------------
//        AdvertType building = advertTypeObj.createBuilding();
//        advertTypeRepository.save(building);
//
//        Advert advertIzmir = advertObj.createAdvertIzmir();
//        advertIzmir.setAdvertType(building);
//
//        //Country turkiye = Country.builder().name("Turkiye").build();
//        // countryRepository.save(turkiye);
//        City izmir = City.builder().name("Izmir").build();
//        izmir.setCountry(turkiye);
//        //cityRepository.save(ankara);
//        District karsiyaka = District.builder().name("Karsiyaka").build();
//        karsiyaka.setCity(izmir);
////        districtRepository.save(cankaya);
//        User andReturnAkin = userObj.createAndReturnAkin();
//        userRepository.save(andReturnAkin);
//
//        advertIzmir.setCountry(turkiye);
//        advertIzmir.setCity(izmir);
//        advertIzmir.setDistrict(karsiyaka);
//        advertIzmir.setUser(andReturnAkin);
//        advertIzmir.setCategory(satilik);
//
//        advertRepository.save(advertIzmir);
    }
}


