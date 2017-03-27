package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface RecruteurDao {
	@SqlUpdate("create table Recruteur (mail varchar(100) primary key, nom varchar(50))")
    void createRecruteurTable();
	
    @SqlUpdate("insert into Recruteur (mail,nom) values (:mail,:nom)")
    @GetGeneratedKeys
    int insert(@BindBean() Recruteur recruteur);
    
    @SqlUpdate("drop table if exists Recruteur")
    void dropRecruteurTable();
    
    @SqlQuery("select * from Recruteur where mail = :mail")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Recruteur findByMail(@Bind("mail") String mail);
    
    @SqlUpdate("delete from Recruteur where mail = :mail")
    @RegisterMapperFactory(BeanMapperFactory.class)
    void delete(@Bind("mail") String mail);
    
    
    /*@SqlUpdate("update Recruteur set ")
    Recruteur updateRec(@Bind("mail") String mail);*/
}
