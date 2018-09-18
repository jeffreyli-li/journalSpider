package com.journal;

import java.util.Map;

/**
 * 1. validate mysql connection, and table schema.
 * 2. 
 * @author shshen
 *
 */
public class SpiderMain {

	public static void main(String args[]){
		
		if(args.length<0){
			System.out.println("please set journal URL");
			return;
		}
		
		SpiderMain spider = new SpiderMain();
		String journalUrl = args[0];
		Map<String, Journal> jMap = spider.parseConf();
		Journal j = null;
		for(String s: jMap.keySet()){
			if(journalUrl.startsWith(s)){
				j = jMap.get(s);
				break;
			}
		}
		
		spider.crawl(j);
	}
	
	private Map<String, Journal> parseConf(){
		return null;
	}
	
	private void crawl(Journal j){
		
	}
}
