package bot.model;
/**
 *Contains the information on the user. 
 *@author Davis Kerr
 *@version 1.0
 */
public class ChatbotUser 
{
	/**
	 * The users age.
	 */
	private int age;
	/**
	 * The users name.
	 */
	private String name;
	/**
	 * The users wieght.
	 */
	private double wieght;
	/**
	 * The users favorite food.
	 */
	private String favoriteFood;

	/**
	 * The basic constructor.
	 */
	public ChatbotUser() 
	{

		this.age = 0;
		this.name = "derp";
		this.wieght = 550;
		this.favoriteFood = "pizza";

	}

	
	//getters:
	/**
	 * Returns the users name.
	 * @return name the users name
	 */
	public String getName() 
	{
		return name;
	}
	
	/**
	 *Returns the users age. 
	 * @return age The users age.
	 */
	public int getAge() 
	{
		return age;
	}
	
	/**
	 *Returns the users wieght. 
	 * @return wieght The users wieght.
	 */
	public double getWieght()
	{
		return wieght;
	}
	
	/**
	 * returns the users favorite food.
	 * @return favoriteFood the users favorite food.
	 */
	public String getFavoriteFood()
	{
		return favoriteFood;
	}
	
	
	//setters:
	/**
	 * Sets/changes the users name.
	 * @param userInput What the user typed in.
	 */
	public void setName(String userInput)
	{
		name = userInput;
	}
	
	/**
	 * Sets/changes the users age.
	 * @param userInput What the user typed in.
	 */
	public void setAge(int userInput)
	{
		age = userInput;
	}
	
	/**
	 * Sets/changes the users wieght.
	 * @param userInput What the user typed in.
	 */
	public void setWieght(double userInput)
	{
		wieght = userInput;
	}
	
	/**
	 * Sets/changes the users favorite food.
	 * @param userInput What the user typed in.
	 */
	public void setFavoriteFood(String userInput)
	{
		favoriteFood = userInput;
	}
}
