package fr.iutinfo.skeleton.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface EtudiantDao {
	@SqlUpdate("create table Etudiant (mail varchar(100) primary key)"/*"create table Etudiant (mail varchar(100) primary key , name varchar(100),prenom varchar(100), password varchar(64), birth date,cv varchar(50), rayon int, formation varchar(200), experience varchar(250), dispo varchar(250), photo varchar(100) )"*/)
    void createEtuTable();

	@SqlUpdate("insert into Etudiant (mail,name,prenom,password,birth,cv,rayon,formation,experience,dispo,photo) values(:mail,:name,:prenom,:password,:birth,:cv,:rayon,:formation,:experience,:dispo,:photo)")
	@GetGeneratedKeys
	int insert(@BindBean() Etudiant etu);
	
	
	@SqlUpdate("drop table if exists Etudiant")
    void dropUserTable();
	

    @SqlQuery("select * from Etudiant where mail = :mail")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Etudiant findByMail(@Bind("mail") String mail);
    
    @SqlUpdate("delete from Etudiant where mail = :mail")
    void delete(@Bind("mail") String mail);
    
    @SqlQuery("select count(*) from Etudiant")
    @RegisterMapperFactory(BeanMapperFactory.class)
    String countall();
    
    @SqlQuery("select * from Etudiant" )
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<User> listall();

    @SqlUpdate("update Etudiant set prenom = :prenom where mail = :mail")
    void update(@Bind("mail") String mail);
    
    void close();
}
