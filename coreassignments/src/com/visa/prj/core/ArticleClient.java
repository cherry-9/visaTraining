package com.visa.prj.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.visa.prj.entity.Article;

public class ArticleClient {

	public static void main(String[] args) {
		List<Article> articles = new ArrayList<>();
		articles.add(new Article("NoDBA",561,"bliki",Arrays.asList("nosql","people","orm")));
		articles.add(new Article("Infodesk",1145,"bliki",Arrays.asList("nosql","writing")));
		articles.add(new Article("OrmHate",1718,"bliki",Arrays.asList("nosql","orm")));
		articles.add(new Article("ruby",1313,"article",Arrays.asList("ruby")));
		articles.add(new Article("DDD_Aggregate",482,"bliki",Arrays.asList("nosql","ddd")));
		
		printTotalWordCount(articles); // 5219
		printArticlesByType(articles); //{bliki:4, article: 1}
		
		// use flatMap, Function.identity and groupingby and Collectors.counting to solve this
		printTagCount(articles); // nosql: 4, ruby : 1, 
	}

	private static void printTagCount(List<Article> articles) {
		
		Map<String,Long > hs =articles.stream().flatMap(p->p.getTags().stream()).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.println(hs);
		 
	}
		

	private static void printArticlesByType(List<Article> articles) {
		
		//HashMap<String,Integer> hs=new HashMap<String, Integer>();		
		
		Map<String,Long > hs=articles.stream().collect(Collectors.groupingBy(Article::getType,Collectors.counting()));
		
//		articles.stream().map(p->p.getType()).forEach(p->
//		{
//				if(hs.containsKey(p)) {
//					hs.replace(p, hs.get(p)+1);
//				}
//				else hs.put(p,1);
//				});
		System.out.println(hs);
//		
//		articles.stream().map(p->{
//			HashMap<String,Integer> hs=new HashMap<String, Integer>();					
//			
//									});
		 
	}

	private static void printTotalWordCount(List<Article> articles) {
		int count=0;
		
		//articles.forEach(p->count+=p.getWords());
		count=articles.stream().map(p->p.getWords()).reduce(0,(a,b)->a+b);
		System.out.println(count);
		
	}

}
