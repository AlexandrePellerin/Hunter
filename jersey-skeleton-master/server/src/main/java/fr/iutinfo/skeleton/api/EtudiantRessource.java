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

import fr.iutinfo.skeleton.common.dto.EtudiantDto;

@Path("/Etu")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EtudiantRessource {

	final static Logger logger = LoggerFactory.getLogger(EtudiantRessource.class);
	private static EtudiantDao dao = getDbi().open(EtudiantDao.class);

	public EtudiantRessource() throws SQLException {
		if (!tableExist("Etudiant")) {
			logger.debug("Create table Etudiant");
			dao.createEtuTable();
			dao.insert(new Etudiant("mail", "123", "testnom", "prenom", "1995-04-06", "url cv", 5, "urlformation",
					"urlexperience", "urldispo", "urlphoto"));
		}
	}

	@POST
	@Path("/add")
	public EtudiantDto createEtu(EtudiantDto dto) {
		Etudiant etu = new Etudiant();
		etu.initFromDto(dto);
		dao.insert(etu);
		return dto;
	}



	@GET
	@Path("/{mail}")
	public EtudiantDto getEtu(@PathParam("mail") String mail) {
		Etudiant etu = dao.findByMail(mail);
		if (etu == null) {
			throw new WebApplicationException(404);
		}
		return etu.convertToDto();
	}

	// The Java method will process HTTP GET requests
	@GET
	public String getClichedMessage() {
		// Return some cliched textual content

		return dao.countall();
	}
	
    @DELETE
    @Path("/{mail}")
    public void deleteUser(@PathParam("mail") String mail) {
        dao.delete(mail);
    }
    
    @PUT
    public void updateEtu(EtudiantDto dto){
    	Etudiant etu = new Etudiant();
		etu.initFromDto(dto);
		dao.update(etu.getMail());
    }
    
    @DELETE
    @Path("/reset")
    public void resetTable() {
        dao.dropEtuTable();
        dao.createEtuTable();
    }


}
