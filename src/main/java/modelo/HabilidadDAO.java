/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Alan
 */
public class HabilidadDAO {
    private SessionFactory sessionFactory;
    public HabilidadDAO(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    public boolean nuevaHabilidad(Habilidad e){
         // arbrimos la sesion son sessionFactory 
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            //iniciamos la transaccion, la consulta a realizar
            tx = session.beginTransaction();
            session.persist(e);
            
            tx.commit();
        }
        catch (Exception er) {
            //si hay un problema regresamos la base aun estado antes de la consulta
            if (tx!=null){
                tx.rollback();
           }
           er.printStackTrace(); 
        }finally {
            //cerramos la session
            session.close();
        }
        return true;
    
    }
    
    public boolean eliminaHabilidad(Habilidad e){
         // arbrimos la sesion son sessionFactory 
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            //iniciamos la transaccion, la consulta a realizar
            tx = session.beginTransaction();
            session.delete(e);
            
            tx.commit();
        }
        catch (Exception er) {
            //si hay un problema regresamos la base aun estado antes de la consulta
            if (tx!=null){
                tx.rollback();
           }
           er.printStackTrace(); 
        }finally {
            //cerramos la session
            session.close();
        }
        return true;
    
    }
    
    public boolean actualizaHabilidad(Habilidad e){
         // arbrimos la sesion son sessionFactory 
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            //iniciamos la transaccion, la consulta a realizar
            tx = session.beginTransaction();
            session.update(e);
            
            tx.commit();
        }
        catch (Exception er) {
            //si hay un problema regresamos la base aun estado antes de la consulta
            if (tx!=null){
                tx.rollback();
           }
           er.printStackTrace(); 
        }finally {
            //cerramos la session
            session.close();
        }
        return true;
    
    }
}
