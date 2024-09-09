package org.chintanu;

import org.chintanu.entity.ChiefMinister;
import org.chintanu.entity.Country;
import org.chintanu.entity.PrimeMinister;
import org.chintanu.entity.State;
import org.chintanu.entity.enumerations.CountryContinent;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        //jpacrudoracle();
        jpacrudh2();
    }

    public static void jpacrudoracle() {

        EntityManager entityManager = Persistence.createEntityManagerFactory("oracledb").createEntityManager();

        Country argetina = entityManager.find(Country.class, "AR");
        System.out.println(argetina);

    }

    public static void jpacrudh2() {

        EntityManager entityManager = Persistence.createEntityManagerFactory("h2db").createEntityManager();

        /*Country argetina = entityManager.find(Country.class, "A");
        System.out.println("First : " + argetina);

        if (null == argetina) {

            argetina = new Country("A", "Argentina", 2);

            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(argetina);

            transaction.commit();
        }

        Country argetina2 = entityManager.find(Country.class, "A");
        System.out.println("Second : " + argetina2);*/

        //Country india = new Country("RUS", "Russia", 2, CountryContinent.ASIA);

        Country india = new Country();
        india.setContinent(CountryContinent.ASIA);
        india.setCountryName("India");
        india.setRegionId(2);

        //Embedded
        State odisha = new State(21, "Odisha");
        india.setState(odisha);

        //ElementCollection
        State up = new State(80, "Uttar Pradesh");
        State uk = new State(10, "Uttarakhand");
        State bihar = new State(25, "Bihar");
        Set<State> states = new HashSet<>();
        states.add(up);
        states.add(uk);
        states.add(bihar);
        india.setStates(states);

        //OneToOne
        LocalDate startDate = LocalDate.of(2014, 06, 15);
        LocalDate endDate = LocalDate.of(2034, 05, 18);
        PrimeMinister modi = new PrimeMinister("Narendra Modi", startDate, endDate);
        india.setCountryPM(modi);

        //OneToMany - Join Column
        ChiefMinister cmOdisha = new ChiefMinister("Naveen Pattnaik", startDate, endDate);
        ChiefMinister cmUP = new ChiefMinister("Yogi Adityanath", startDate, endDate);
        ChiefMinister cmMaha = new ChiefMinister("Amit Shinde", startDate, endDate);
        List<ChiefMinister> lstCMs = new ArrayList<>();
        lstCMs.add(cmOdisha);
        lstCMs.add(cmUP);
        lstCMs.add(cmMaha);
        india.setLstCMs(lstCMs);

        //Transactional Operation
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(india);
        String id = india.getCountryId();
        System.out.println(id);

        transaction.commit();

        Country con = entityManager.find(Country.class, id);
        System.out.println(con);

        /*transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.remove(con);
        transaction.commit();*/
    }
}