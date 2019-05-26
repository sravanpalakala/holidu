package com.holidu.interview.assignment;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Aggregation {

	
	public String findAggregation(TreeModel[] treeModel) {
		StringBuffer sb = new StringBuffer();
		String[] strnArray = new String[treeModel.length];
		int count = 0;
		Map<String, Integer> strMap = new HashMap<String, Integer>();
		for (TreeModel tree : treeModel) {
			if (tree != null && tree.getSpc_common() != null) {
				strnArray[count] = tree.getSpc_common();
				count++;
			}

		}
		for (String str : strnArray) {
			if (strMap.containsKey(str)) {
				strMap.put(str, strMap.get(str) + 1);
			} else {
				strMap.put(str, 1);
			}
		}
		HashMap<String, Integer> keyValuesMap = new HashMap<>();
		for (Map.Entry<String, Integer> entry : strMap.entrySet()) {

			if (entry.getValue() > 1) {
				//System.out.println("key" + entry.getKey() + "value:" + entry.getValue());
				keyValuesMap.put(entry.getKey(), entry.getValue());
					} else {
				keyValuesMap.put(entry.getKey(), entry.getValue());
			}
		}

		HashMap<String, Integer> resultMap = sortHashMapByValues(keyValuesMap);

		for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
			sb.append(String.valueOf(entry.getKey()) + ":" + entry.getValue());
		}

		return sb.toString();

	}

	public HashMap<String, Integer> sortHashMapByValues(HashMap<String, Integer> passedMap) {

		HashMap<String, Integer> result = passedMap.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toMap(
						Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

		return result;
	}

}
