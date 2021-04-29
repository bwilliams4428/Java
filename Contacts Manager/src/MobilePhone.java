import java.util.*;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contacts> contactList = new ArrayList<Contacts>();

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contactList = new ArrayList<Contacts>();
    }

    public boolean addNewContact(Contacts contact){
        if(findContact(contact.getName()) >= 0){
            System.out.println("Contact is already on file");
            return false;
        }
        contactList.add(contact);
        return true;
    }

    public boolean removeContact(Contacts contact){
        int foundPostition = findContact(contact);
        if(foundPostition < 0){
            System.out.println(contact.getName() +" ,was not found.");
            return false;
        }
        this.contactList.remove(foundPostition);
        System.out.println(contact.getName() + " ,was deleted.");
        return true;
    }
    private int findContact(Contacts contact){
       return  this.contactList.indexOf(contact);
    }

    private int findContact(String contactName){
        for(int i = 0; i < contactList.size(); i++){
            Contacts contact = this.contactList.get(i);
            if(contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact){
        int foundPostition = findContact(oldContact);
        if(foundPostition < 0){
            System.out.println(oldContact.getName() +" ,was not found.");
            return false;
        }else if(findContact(newContact.getName())!=-1){
            System.out.println("Contact with name " + newContact.getName() + " already exists. Update not" +
                    "sucessful");
            return false;

        }
        this.contactList.set(foundPostition, newContact);
        System.out.println((oldContact.getName() + " was replaced  with " + newContact.getName()));
        return true;
    }

    public String queryContact(Contacts contact){
        if (findContact(contact)>= 0){
            return contact.getName();
        }
        return null;
    }

    public Contacts queryContact(String name){
        int position = findContact(name);
        if(position >=0){
            return this.contactList.get(position);
        }
        return null;
    }
    public void printContacts(){
        for(int i =0; i < this.contactList.size(); i++){
            System.out.println((i+1) +" . "+ this.contactList.get(i).getName() + " ->"  + this.contactList.get(i).getPhoneNumber());
        }
    }
}
