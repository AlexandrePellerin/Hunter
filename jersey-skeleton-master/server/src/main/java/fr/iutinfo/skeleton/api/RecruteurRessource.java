package fr.iutinfo.skeleton.api;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.RecruteurDto;

@Path("/Rec")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RecruteurRessource {
	final static Logger logger = LoggerFactory.getLogger(RecruteurDao.class);
    private static RecruteurDao dao = getDbi().open(RecruteurDao.class);

    public  RecruteurRessource() throws SQLException {
        if (!tableExist("Recruteur")) {
            logger.debug("Create table Recuteur");
            dao.createRecruteurTable();
            dao.insert(new Recruteur("mail0","defaultname","defaultpasswd","defaultprenom", "defaultsociete", "defaultaddress", "defaultsiret"));
        }
    }
    
    @POST
    public RecruteurDto createRecruteur(RecruteurDto dto) {
        Recruteur rec = new Recruteur();
        rec.initFromDto(dto);
        dao.insert(rec);
        return dto;
    }
    
    @PUT
    public void updateRecruteur(RecruteurDto dto) {
    	dao.updateRec(dto.getMail(), dto.getNom(), dto.getPasswd(), dto.getPrenom(), dto.getSociete(), dto.getAddress(), dto.getSiret());
    }
    
	@GET
	@Path("/{mail}")
	public RecruteurDto findRecruteurByMail(@PathParam("mail") String mail) {
		Recruteur rec = dao.findByMail(mail);
        if (rec == null) {
            throw new WebApplicationException(404);
        }
		return rec.convertToDto();
	}
	
    
    @DELETE
    @Path("/{mail}")
    public void deleteUser(@PathParam("mail") String mail) {
        dao.delete(mail);
    }
    
    @DELETE
    @Path("/reset")
    public void resetTable() {
        dao.dropRecruteurTable();
        dao.createRecruteurTable();
    }
}
