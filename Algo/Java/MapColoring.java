/* http://www.geeksforgeeks.org/backttracking-set-5-m-coloring-problem/ */
/*
The Four Color Theorem states that any map on a plane can be colored with no more than four colors, so that no two countries with a common border are the same color.

@map : map[5][3]==8 means the 3th country adjacent to country 5 is country 8
@countryColor: An array of “colors”, where countryColor[i] is the color of the ith country

*/

class MapColoring
{
	//there are total 7 countries
	private static final int COUNTRIES=7;
	//map of countries
	private int[][] map;
	//to store the color of the ith country
	private Color[] countryColor;

	// Enum Color to identify colors available
	public enum Color
	{
		// 4 colors available
		NONE(0), RED(1), YELLOW(2), GREEN(3), BLUE(4);
		//numeric value of the color
		public final int value;

		//constructor for Color enum
		private Color(final int value)
		{
			this.value = value;
		}
		//get the name of the color
		public static Color getName(int value)
		{
  			for(Color c: Color.values())
  			{
    			if(c.value == value)
    			{
      				return c;
    			}
 	 		}
  			return null;// not found
		}
	}
	
	//intialize the map
	//@map : map[5][3]==8 means the 3th country adjacent to country 5 is country 8
	public MapColoring()
	{
		map = new int[COUNTRIES][];
    	map[0] = new int[] { 1, 4, 2, 5 };
    	map[1] = new int[] { 0, 4, 6, 5 };
    	map[2] = new int[] { 0, 4, 3, 6, 5 };
    	map[3] = new int[] { 2, 4, 6 };
    	map[4] = new int[] { 0, 1, 6, 3, 2 };
    	map[5] = new int[] { 2, 6, 1, 0 };
    	map[6] = new int[] { 2, 3, 4, 1, 5 };

    	countryColor = new Color[COUNTRIES];
    	//initialize the country's color with NONE
    	for(int i=0;i<COUNTRIES;i++)
    		countryColor[i] = Color.NONE;
	}

	//check if it is possible to color countries with 4 colors
	private boolean colorCountries(int country, Color color)
	{
		//check if it is safe to color country "country" with color "color"
		if(isSafeToColor(country, color))
		{
			//set the color of the country "country" = "color"
			countryColor[country] = color;
			//loop through the colors and select next country
			for(int i=Color.RED.value;i<Color.BLUE.value;i++)
			{
				if(colorCountries(country+1, Color.getName(i)))
					return true;
			}
		}
		//if it is not safe then return false
		return false;
	}
	// check if the country is safe to color with "color"
	private boolean isSafeToColor(int country, Color color)
	{
		//specified country is not present in the list
		if(country > map.length)
			return false;
		//loop through the list of adjacent countries for the given country
		// and check if any country is already colored with color "color"
		for(int i=0;i<map[country].length;i++)
		{
			//get the adjacent country
			int adjacentCountry = map[country][i];
			//if any adjacent country is color with "color"
			//then return false
			if(countryColor[adjacentCountry]==color)
			{
				return false;
			}
		}
		//else return true
		return true;
	}

	private void printMap()
	{
		for(int i=0;i<countryColor.length;i++)
		{
			System.out.println("Country: "+ i+" color:"+ countryColor[i].name());
		}
	}

	public static void main(String args[])
	{
		MapColoring coloring = new MapColoring();
		//start with country 0 and color RED
		coloring.colorCountries(0, Color.RED);
		coloring.printMap();
	}
}
