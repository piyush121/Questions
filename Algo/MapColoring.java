/*
The Four Color Theorem states that any map on a plane can be colored with no more than four colors, so that no two countries with a common border are the same color.

@map : map[5][3]==8 means the 3th country adjacent to country 5 is country 8
@countryColor: An array of “colors”, where countryColor[i] is the color of the ith country

*/

class MapColoring
{
	private static final int COUNTRIES=7;
	private int[][] map;
	private Color[] countryColor;

	public enum Color
	{
		NONE(0), RED(1), YELLOW(2), GREEN(3), BLUE(4);
		public final int value;

		private Color(final int value)
		{
			this.value = value;
		}

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
    	for(int i=0;i<COUNTRIES;i++)
    		countryColor[i] = Color.NONE;
	}

	private boolean colorCountries(int country, Color color)
	{
		if(isSafeToColor(country, color))
		{
			countryColor[country] = color;
			//System.out.println(Color.RED.value);
			for(int i=Color.RED.value;i<Color.BLUE.value;i++)
			{
				//System.out.println("color: " + Color.getName(i).name());
				if(colorCountries(country+1, Color.getName(i)))
					return true;
			}
		}
		return false;
	}

	private boolean isSafeToColor(int country, Color color)
	{
		//specified country is not present in the list
		if(country > map.length)
			return false;
		for(int i=0;i<map[country].length;i++)
		{
			int adjacentCountry = map[country][i];
			if(countryColor[adjacentCountry]==color)
			{
				//System.out.println("isSafeToColor: "+false);
				return false;
			}
		}
		//System.out.println("isSafeToColor: "+true);
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
		coloring.colorCountries(0, Color.RED);
		coloring.printMap();
	}
}
