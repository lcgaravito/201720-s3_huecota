/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.nocompila.huecota.persistence;

import co.edu.uniandes.nocompila.huecota.entities.AccidenteEntity;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;


/**
 *
 * @author ma.puentes
 */
@RunWith(Arquillian.class)
public class AccidentePersistenceTest
{
	
	//persistence: es el objeto de la clase que se va a probar. El contenedor inyectar� una instancia de esta clase.
    //em: un EntityManager para verificar los datos directamente sobre la base de datos
    //utx: un UserTransactions para manipular los datos directamente sobre la base de datos
    //data: este arreglo contendr� el conjunto de datos de prueba
	
	
	
	public AccidentePersistenceTest()
	{
		
	}
	
	/**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de XYZ, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyecci�n de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment()
	{
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AccidenteEntity.class.getPackage())
                .addPackage(AccidentePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
	
	@BeforeClass
	public static void setUpClass()
	{
		
	}
	
	@AfterClass
	public static void tearDownClass()
	{
		
	}
	
	@Before
	public void setUp()
	{
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
	
	@After
	public void tearDown()
	{
		
	}

	/**
	 * Test of create method, of class AccidentePersistence.
	 */
	@Test
	public void testCreate() throws Exception
	{
		
	}

	/**
	 * Test of update method, of class AccidentePersistence.
	 */
	@Test
	public void testUpdate() throws Exception
	{
		
	}

	/**
	 * Test of delete method, of class AccidentePersistence.
	 */
	@Test
	public void testDelete() throws Exception
	{
		
	}

	/**
	 * Test of find method, of class AccidentePersistence.
	 */
	@Test
	public void testFind() throws Exception
	{
		
	}

	/**
	 * Test of findAll method, of class AccidentePersistence.
	 */
	@Test
	public void testFindAll() throws Exception
	{
		
	}
	
}
