package org.terra.resource

import org.terra.entity.PersonEntity
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class PersonResource {

    private val persons: ArrayList<PersonEntity> = ArrayList();

    @POST
    fun addPerson(person: PersonEntity) : PersonEntity {
        persons.add(person)
        return person
    }

    @GET
    fun getAllPersons() = persons

    @GET
    @Path("/{name}")
    fun getPersonByName(@PathParam("name") name: String): PersonEntity? {
        return persons.find { it.name == name }
    }
}