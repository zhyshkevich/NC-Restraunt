package by.training.nc.dev3.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import by.training.nc.dev3.beans.Food;
import by.training.nc.dev3.beans.Menu;


/**
 * 
 * Serialization for Menu objects
 * 
 * @author ������
 *
 */
public class MenuSerializer {
	
	
	/**
	 * Serializes the Menu object
	 * 
	 * @param bill
	 */
	public static void serializer(Menu menu)
	{
		String filename = "C:\\Users\\������\\workspace\\netcracker\\NC-Restraunt\\Restraunt\\src\\main\\java\\by\\training\\nc\\dev3\\files\\input\\menu.ser";

		try 
		{
			FileOutputStream fs = new FileOutputStream(filename);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(menu);
			os.close();
		}
		catch (NotSerializableException e)
		{
			System.out.println("Object can't be serialized!");
		} catch (IOException e) {
			System.err.println(e);;
		}
	}
	
	
	/**
	 * 
	 * Deserializes the Menu object
	 * 
	 * @return
	 * @throws InvalidObjectException
	 */
	public static Menu deserialization() throws InvalidObjectException
	{
		String filename = "C:\\Users\\������\\workspace\\netcracker\\NC-Restraunt\\Restraunt\\src\\main\\java\\by\\training\\nc\\dev3\\files\\input\\menu.ser";

		ObjectInputStream os = null;
		try 
		{
			FileInputStream fs = new FileInputStream(filename);
			os = new ObjectInputStream(fs);
			Object ob = os.readObject();
			Menu m = (Menu) ob;
			//os.mlose();
			return m;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Can't find file to recover object from!");
		}
		catch (IOException e)
		{
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally	
		{
			try 
			{
				if (os != null)
				{
					os.close();
				}
			}
			catch (IOException e)
			{
				System.err.println("Error with closing the flow!");
			}
		}
		throw new InvalidObjectException("Object was't recovered");
		
	}

}
