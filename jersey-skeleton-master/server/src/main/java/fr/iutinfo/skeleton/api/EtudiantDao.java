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
	@SqlUpdate("create table Etudiant (mail varchar(100) primary key, name carchar(50), prenom varchar(50),password varchar(50), birth varchar(10), cv varchar(100), rayon int, formation varchar(200), experience varchar(200), dispo varchar(200), photo varchar(100))"/*"create table Etudiant (mail varchar(100) primary key , name varchar(100),prenom varchar(100), password varchar(64), birth date,cv varchar(50), rayon int, formation varchar(200), experience varchar(250), dispo varchar(250), photo varchar(100) )"*/)
    void createEtuTable();

	@SqlUpdate("insert into Etudiant (mail,name,prenom,password,birth,cv,rayon,formation,experience,dispo,photo) values(:mail,:name,:prenom,:password,:birth,:cv,:rayon,:formation,:experience,:dispo,:photo)")
	@GetGeneratedKeys
	int insert(@BindBean() Etudiant etu);
	
	
	@SqlUpdate("drop table if exists Etudiant")
    void dropEtuTable();
	

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

    @SqlUpdate("update Etudiant set prenom = :prenom , name = :name , prenom = :prenom , birth = :birth , cv = :cv , rayon = :rayon , formation = :formation , experience = :experience , dispo = :dispo , photo = :photo where mail = :mail")
    void update(@Bind("mail") String mail,@Bind("prenom") String prenom, @Bind("name") String name,@Bind("birth") String birth,@Bind("cv") String cv, @Bind("rayon") int rayon,@Bind("formation") String formation, @Bind("experience") String experience,@Bind("dispo") String dispo, @Bind("photo") String photo);
    
    void close();
}
