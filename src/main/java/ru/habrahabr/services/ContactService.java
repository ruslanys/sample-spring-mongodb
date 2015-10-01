package ru.habrahabr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.habrahabr.dao.SequenceDao;
import ru.habrahabr.dao.ContactDao;
import ru.habrahabr.model.Contact;

import java.util.List;

/**
 * Date: 26.03.2014
 * Time: 20:09
 *
 * @author Ruslan Molchanov (ruslanys@gmail.com)
 */
@Service
public class ContactService {
    @Autowired private SequenceDao sequenceDao;
    @Autowired private ContactDao contactDao;

    public void add(Contact contact) {
        contact.setId(sequenceDao.getNextSequenceId(Contact.COLLECTION_NAME));
        contactDao.save(contact);
    }

    public void update(Contact contact) {
        contactDao.save(contact);
    }

    public Contact get(Long id) {
        return contactDao.get(id);
    }

    public List<Contact> getAll() {
        return contactDao.getAll();
    }

    public void remove(Long id) {
        contactDao.remove(id);
    }
}
