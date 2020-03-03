package com.us.algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class MoviesTitlesRest {
	
	public static void main(String[] args) throws Exception {
		int totalPages;
		String response =sendGet("spiderman", 1);
		
		JsonFactory factory = new JsonFactory();
		
		JsonParser  parser  = factory.createParser(response);
		
		while (!parser.isClosed()){
			
			JsonToken jsonToken = parser.nextToken();
			if(jsonToken.FIELD_NAME.equals(jsonToken)){
				
				String fieldName = parser.getCurrentName();
				
				
				
				//if value is not array
				if(!JsonToken.START_ARRAY.equals(jsonToken)){
					//next token for value
					jsonToken = parser.nextToken();
					if(!JsonToken.START_ARRAY.equals(jsonToken)){
					
						String value = parser.getValueAsString();
						System.out.println(fieldName+": "+value);
					}
				} else {
					
						System.out.println(fieldName);
		        		ObjectMapper objectMapper = new ObjectMapper();
		        		TypeFactory typeFactory = objectMapper.getTypeFactory();
		        		List<String> datavalues = objectMapper.readValue(response, typeFactory.constructCollectionType(List.class, String.class));
		        		
		        }
		        	
			}
		}    
		        //if()
		        
		        //jsonToken = parser.nextToken();
		        
			
	}
			
		//sendGet("spiderman", 1);
	
	
	/*
	 * write an HTTP GET method to retrieve information from a particular movie database. 
	 * It has one parameter: a string, substr. The function must perform the following tasks:
	 * 1)Query https://jsonmock.hackerrank.com/api/movies/search/?Title=substr (where substr is the value of substr). 
	 * The query response from the website is a JSON response with the following five fields:
	 * 1.1) page: The current page.
	 * 1.2) per_page: The maximum number of results per page.
	 * 1.3) total: The total number of such movies having the substring substr in their title.
	 * 1.4) total_pages: The total number of pages which must be queried to get all the results.
	 * 1.5) data: An array of JSON objects containing movie information where the Title field denotes the title of the movie. 
	 * Note that this field is paginated so, in order to incorporate pagination, you must query 
	 * https://jsonmock.hackerrank.com/api/movies/search/?Title=substr&page=pageNumber, 
	 * where pageNumber is an integer denoting the page you would like to view (e.g., 1, 2, etc.).
	 * 2) Create an array of strings named titles to store total elements.
	 * For each page of results, store the Title of each movie in the titles array.
	 * 3) Sort titles in ascending order and return it as your answer.
	 * 
	 * Input Format: A single string, substr, denoting the substring you must query for.
	 * Output Format: Return an array of strings corresponding to movie titles with susbtr in their Title, 
	 * sorted in ascending order.
	 * 
	 * Sample Input 1: "spiderman"
	 * Sample Output 1: 
	 *	Amazing Spiderman Syndrome
	 *	Fighting, Flying and Driving: The Stunts of Spiderman 3
	 *	Hollywood's Master Storytellers: Spiderman Live
	 *	Italian Spiderman
	 *	Spiderman
	 *	Spiderman
	 *	Spiderman 5
	 *	Spiderman and Grandma
	 *	Spiderman in Cannes
	 *	Superman, Spiderman or Batman
	 *	The Amazing Spiderman T4 Premiere Special
	 *	The Death of Spiderman
	 *	They Call Me Spiderman
	 * Explanation 0:
	 * For this example, we want all the movie titles containing the substring spiderman. 
	 * The response for the query https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman&page=1 is:
	 * {
		  "page": "1",
		  "per_page": 10,
		  "total": 13,
		  "total_pages": 2,
		  "data": [
		    {
		      "Poster": "https://images-na.ssl-images-amazon.com/images/M/MV5BYjFhN2RjZTctMzA2Ni00NzE2LWJmYjMtNDAyYTllOTkyMmY3XkEyXkFqcGdeQXVyNTA0OTU0OTQ@._V1_SX300.jpg",
		      "Title": "Italian Spiderman",
		      "Type": "movie",
		      "Year": "2007",
		      "imdbID": "tt2705436"
		    },
		    {
		      "Poster": "https://images-na.ssl-images-amazon.com/images/M/MV5BMjQ4MzcxNDU3N15BMl5BanBnXkFtZTgwOTE1MzMxNzE@._V1_SX300.jpg",
		      "Title": "Superman, Spiderman or Batman",
		      "Type": "movie",
		      "Year": "2011",
		      "imdbID": "tt2084949"
		    },
		    {
		      "Poster": "N/A",
		      "Title": "Spiderman",
		      "Type": "movie",
		      "Year": "1990",
		      "imdbID": "tt0100669"
		    },
		    {
		      "Poster": "N/A",
		      "Title": "Spiderman",
		      "Type": "movie",
		      "Year": "2010",
		      "imdbID": "tt1785572"
		    },
		    {
		      "Poster": "N/A",
		      "Title": "Fighting, Flying and Driving: The Stunts of Spiderman 3",
		      "Type": "movie",
		      "Year": "2007",
		      "imdbID": "tt1132238"
		    },
		    {
		      "Poster": "http://ia.media-imdb.com/images/M/MV5BMjE3Mzg0MjAxMl5BMl5BanBnXkFtZTcwNjIyODg5Mg@@._V1_SX300.jpg",
		      "Title": "Spiderman and Grandma",
		      "Type": "movie",
		      "Year": "2009",
		      "imdbID": "tt1433184"
		    },
		    {
		      "Poster": "N/A",
		      "Title": "The Amazing Spiderman T4 Premiere Special",
		      "Type": "movie",
		      "Year": "2012",
		      "imdbID": "tt2233044"
		    },
		    {
		      "Poster": "N/A",
		      "Title": "Amazing Spiderman Syndrome",
		      "Type": "movie",
		      "Year": "2012",
		      "imdbID": "tt2586634"
		    },
		    {
		      "Poster": "N/A",
		      "Title": "Hollywood's Master Storytellers: Spiderman Live",
		      "Type": "movie",
		      "Year": "2006",
		      "imdbID": "tt2158533"
		    },
		    {
		      "Poster": "N/A",
		      "Title": "Spiderman 5",
		      "Type": "movie",
		      "Year": "2008",
		      "imdbID": "tt3696826"
		    }
		  ]
		}
	 * The response for the query https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman&page=2 is:
			{
			  "page": "2",
			  "per_page": 10,
			  "total": 13,
			  "total_pages": 2,
			  "data": [
			    {
			      "Poster": "N/A",
			      "Title": "They Call Me Spiderman",
			      "Type": "movie",
			      "Year": "2016",
			      "imdbID": "tt5861236"
			    },
			    {
			      "Poster": "N/A",
			      "Title": "The Death of Spiderman",
			      "Type": "movie",
			      "Year": "2015",
			      "imdbID": "tt5921428"
			    },
			    {
			      "Poster": "https://images-na.ssl-images-amazon.com/images/M/MV5BZDlmMGQwYmItNTNmOS00OTNkLTkxNTYtNDM3ZWVlMWUyZDIzXkEyXkFqcGdeQXVyMTA5Mzk5Mw@@._V1_SX300.jpg",
			      "Title": "Spiderman in Cannes",
			      "Type": "movie",
			      "Year": "2016",
			      "imdbID": "tt5978586"
			    }
			  ]
			}
	 * The respective values of the Title field for each movie in each response page are:
		Italian Spiderman
		Superman, Spiderman or Batman
		Spiderman
		Spiderman
		Fighting, Flying and Driving: The Stunts of Spiderman 3
		Spiderman and Grandma
		The Amazing Spiderman T4 Premiere Special
		Amazing Spiderman Syndrome
		Hollywood's Master Storytellers: Spiderman Live
		Spiderman 5
		They Call Me Spiderman
		The Death of Spiderman
		Spiderman in Cannes
	 * 
	 * We then store each title in our titles array, sort it in ascending order, and return it as our answer.
	 * 
	 */
	
	
	public LinkedList getTitles(String substr, int page){
		
		
		return null;
		
		
	}
	
	private static String sendGet(String substring, int num) throws Exception {

		String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title="+substring+"&page="+num;

		URL obj = new URL(url);
		HttpURLConnection con = ( (HttpURLConnection) obj.openConnection());
		
		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", "Mozilla/5.0");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//return result
		return response.toString();

	}
}
