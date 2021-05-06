package com.myproject.myweb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openkoreantext.processor.KoreanTokenJava;
import org.openkoreantext.processor.OpenKoreanTextProcessorJava;
import org.openkoreantext.processor.tokenizer.KoreanTokenizer;
import org.springframework.stereotype.Service;

import scala.collection.Seq;


//bean ���


// interface �� ������ ���� - ���߻��
// ��ü ���� �������� ����(��ü����DI)
// ���� ��ɿ� �������� ���� �������� �ڵ� �ߺ� ���� & �������� ����
	
	
// �� ���� interface implements ����


@Service
public class ReviewKeywordServiceImpl implements ReviewKeywordService{
	
	@Override
	public String getReviewKeyword(String rev_content) {
		CharSequence normalized = OpenKoreanTextProcessorJava.normalize(rev_content);
		Seq<KoreanTokenizer.KoreanToken> tokens = OpenKoreanTextProcessorJava.tokenize(normalized);
	    List<KoreanTokenJava> reviewContent = OpenKoreanTextProcessorJava.tokensToJavaKoreanTokenList(tokens);
	    
	    Map<String, Integer> keywordCountMap = new HashMap<String, Integer>();
		int count;
	    
	    for(KoreanTokenJava tokenKor : reviewContent) {
	    	String pos = String.valueOf(tokenKor.getPos());
	    	if(pos == "Noun") {
	    		if(keywordCountMap.containsKey(tokenKor.getText())) {
	    			count = keywordCountMap.get(tokenKor.getText()) + 1;
	    			keywordCountMap.put(tokenKor.getText(), count);
	    		}else {
	    			keywordCountMap.put(tokenKor.getText(), 1);
	    		}
	    	}
	    }
	   
	    String keyword = ""; 
	    for(String key: keywordCountMap.keySet()) {
	    	if(keyword.length() >= 50) {
    			break;
    		}
	    	
    		if(keywordCountMap.get(key) > 1) { //
		    	keyword += key + "." + String.valueOf(keywordCountMap.get(key)) + ".";
		    }
    		
	    }
	    
	    if (keyword.length() > 0) {
	    	keyword = keyword.substring(0, keyword.length()-1);
	    }else {
	    	keyword = "Ű���� ����";
	    }
	    
	    return keyword;
	}
	
}
