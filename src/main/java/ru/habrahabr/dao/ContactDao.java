package ru.habrahabr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ru.habrahabr.model.Contact;

import java.util.List;

/**
 * Date: 26.03.2014
 * Time: 19:13
 *
 * @author Ruslan Molchanov (ruslanys@gmail.com)
 */
@Repository
public class ContactDao {
    @Autowired private MongoOperations mongoOperations;

    public void save(Contact contact) {
        mongoOperations.save(contact);
    }

    public Contact get(Long id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), Contact.class);
    }

    public List<Contact> getAll() {
        return mongoOperations.findAll(Contact.class);
    }

    public void remove(Long id) {
        mongoOperations.remove(Query.query(Criteria.where("id").is(id)), Contact.class);
    }
}
