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

import fr.iutinfo.skeleton.common.dto.OffresDto;

@Path("/Off")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OffresRessource {

	final static Logger logger = LoggerFactory.getLogger(RecruteurDao.class);
    private static OffresDao dao = getDbi().open(OffresDao.class);

    public  OffresRessource() throws SQLException {
        if (!tableExist("Offres")) {
            logger.debug("Create table Offres");
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
    
    @GET
    @Path("/{numero}")
    public OffresDto findOffresByNumero(@PathParam("numero") int numero){
    	Offres off = dao.findByNumero(numero);
        if (off == null) {
            throw new WebApplicationException(404);
        }
		return off.convertToDto();
    }
    
    @DELETE
    @Path("/reset")
    public void reset(){
    	dao.dropOffresTable();
    	dao.createOffresTable();
    }
    
    @DELETE
    @Path("/{numero}")
    public void delete(@PathParam("numero") int numero){
    	dao.delete(numero);
    }
    
    @PUT
    public void updateOffres(OffresDto dto){
    	dao.updateOff(dto.getNumero(), dto.getMailRecru(), dto.getPoste(), dto.getDescription(), dto.getNbHeure());
    }
    
}
