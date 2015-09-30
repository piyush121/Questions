import java.util.Random;
public class Deck
{
	private Card[] deckOfCards = new Card[52];
	private static int currentCard;
	
	public Deck()
	{
		int i=0;
		for(int suit=Card.SPADE; suit<=Card.CLUB;suit++)
		{
			for(int rank=1;rank<=13;rank++)
			{
				deckOfCards[i++] = new Card(suit, rank);
			}
		}
		currentCard =0;
	}
	
	public void shuffle()
	{
		Random r = new Random();
		for(int i=deckOfCards.length-1;i>=0;i--)
		{
			int x = r.nextInt(i+1);
			Card temp = deckOfCards[i];
			deckOfCards[i] = deckOfCards[x];
			deckOfCards[x] = temp;
		}
		currentCard = 0;
	}
	
	public Card deal()
	{
		if(currentCard<52)
		{
			return deckOfCards[currentCard++];
		}
		else
		{
			return null;
		}
	}
	
	public static void main(String args[])
	{
		Deck d = new Deck();
		System.out.println(d.deal());
		d.shuffle();
		System.out.println(d.deal());
	}
}

class Card
{
	public final static int SPADE = 0;
	public final static int DIAMOND = 1;
	public final static int HEART = 2;
	public final static int CLUB = 3;
	public final static int JOKER=-1;
	public final int suit;
	public final int rank;
	
	public Card(int suit, int rank)
	{
		this.suit = suit;
		this.rank = rank;
	}
	
	public int getSuit()
	{
		return this.suit;
	}
	
	public int getRank()
	{
		return this.rank;
	}
	
	public String toString()
	{
		return getSuitAsString()+getRankAsString();
	}
	
	public String getSuitAsString()
	{
		switch(this.suit)
		{
			case SPADE:return "S";
			case HEART: return "H";
			case CLUB: return "C";
			case DIAMOND: return "D";
			default: return "JOKER";
		}
	}
	
	public String getRankAsString()
	{
		switch(this.rank)
		{
			case 1:return "A";
			case 2:return "2";
			case 3:return "3";
			case 4:return "4";
			case 5:return "5";
			case 6:return "6";
			case 7:return "7";
			case 8:return "8";
			case 9:return "9";
			case 10:return "10";
			case 11:return "J";
			case 12:return "Q";
			case 13:return "K";
			default:return "";
		}
	}
}

