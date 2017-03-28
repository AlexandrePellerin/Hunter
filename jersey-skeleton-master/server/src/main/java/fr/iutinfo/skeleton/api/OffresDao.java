package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface OffresDao {

	@SqlUpdate("create table Offres (numero integer, mailRecru varchar(50),poste varchar(50),description text, nbHeure integer, constraint pk_Offres primary key (numero))")
    void createOffresTable();

	@SqlUpdate("insert into Offres (numero,mailRecru,poste,description,nbHeure) values (:numero,:mailRecru,:poste,:description,:nbHeure)")
    @GetGeneratedKeys
    int insert(@BindBean() Offres offres);
	
    @SqlUpdate("drop table if exists Offres")
    void dropOffresTable();
    
    @SqlQuery("select * from Offres where numero = :numero")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Offres findByNumero(@Bind("numero") int numero);
    
    @SqlUpdate("delete from Offres where numero = :numero")
    @RegisterMapperFactory(BeanMapperFactory.class)
    void delete(@Bind("numero") int numero);
    
    @SqlUpdate("update Offres set mailRecru = :mailRecru, poste = :poste, description = :description, nbHeure = :nbHeure where numero = :numero")
    Offres updateOff(@Bind("numero") int numero,@Bind("mailRecru") String mailRecru,@Bind("poste") String poste,@Bind("description") String description,@Bind("nbHeure") int nbHeure);

    
}
