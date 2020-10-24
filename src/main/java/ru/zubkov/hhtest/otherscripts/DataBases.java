package ru.zubkov.hhtest.otherscripts;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataBases {
    private List<Person> DAO;
    private int TOKEN = 0;

    {
        DAO = new ArrayList<>();

        DAO.add( new Person( ++TOKEN, "Petya" ) );
        DAO.add( new Person( ++TOKEN, "Vasya" ) );
        DAO.add( new Person( ++TOKEN, "Vita" ) );
    }

    public List<Person> getDAO() {
        return DAO;
    }

    public Person getPersonById( int id ){
        for( int i = 0; i < DAO.size(); i++ ){
            if( DAO.get(i).getId() == id ){
                return DAO.get(i);
            }
        }
        return new Person(0, "Not founded");
        //        return DAO.stream().filter(models -> models.getId() == id).findAny().orElse(null);
    }

    public void create( Person model ){
        model.setId(++TOKEN);
        DAO.add( model );
    }

}
