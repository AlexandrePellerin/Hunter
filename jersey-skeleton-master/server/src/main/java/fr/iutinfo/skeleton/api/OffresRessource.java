package fr.iutinfo.skeleton.api;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

import java.sql.SQLException;

import javax.ws.rs.POST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.OffresDto;
import fr.iutinfo.skeleton.common.dto.RecruteurDto;

public class OffresRessource {

	final static Logger logger = LoggerFactory.getLogger(RecruteurDao.class);
    private static OffresDao dao = getDbi().open(OffresDao.class);

    public  OffresRessource() throws SQLException {
        if (!tableExist("Recruteur")) {
            logger.debug("Create table Recuteur");
            dao.createOffresTable();
            dao.insert(new Offres(0,"mail","poste","description",0));
        }
    }
    
    @POST
    public OffresDto createRecruteur(OffresDto dto) {
        Offres offres = new Offres();
        offres.initFromDto(dto);
        dao.insert(offres);
        return dto;
    }    
}
