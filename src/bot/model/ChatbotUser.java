package bot.model;

public class ChatbotUser 
{
	private int age;
	private String name;
	private double wieght;
	private String favoriteFood;

	public ChatbotUser() 
	{

		this.age = 0;
		this.name = "derp";
		this.wieght = 550;
		this.favoriteFood = "pizza";

	}

	
	//getters:
	public String getName() 
	{
		return name;
	}

	public int getAge() 
	{
		return age;
	}
	
	public double getWieght()
	{
		return wieght;
	}
	
	public String getFavoriteFood()
	{
		return favoriteFood;
	}
	
	
	//setters:
	public void setName(String userInput)
	{
		name = userInput;
	}
	
	public void setAge(int userInput)
	{
		age = userInput;
	}
	
	public void setWieght(double userInput)
	{
		wieght = userInput;
	}
	
	public void setFavoriteFood(String userInput)
	{
		favoriteFood = userInput;
	}
}
