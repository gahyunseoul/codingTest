package lv_1.CodingTest6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class S61_햄버거만들기 {
	/*
	햄버거 가게에서 일을 하는 상수는 햄버거를 포장하는 일을 합니다. 
	함께 일을 하는 다른 직원들이 햄버거에 들어갈 재료를 조리해 주면 조리된 순서대로 상수의 앞에 아래서부터 위로 쌓이게 되고, 
	상수는 순서에 맞게 쌓여서 완성된 햄버거를 따로 옮겨 포장을 하게 됩니다. 
	상수가 일하는 가게는 정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장을 합니다.
	상수는 손이 굉장히 빠르기 때문에 상수가 포장하는 동안 속 재료가 추가적으로 들어오는 일은 없으며, 
	재료의 높이는 무시하여 재료가 높이 쌓여서 일이 힘들어지는 경우는 없습니다.

	예를 들어, 상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]일 때, 
	상수는 여섯 번째 재료가 쌓였을 때, 세 번째 재료부터 여섯 번째 재료를 이용하여 햄버거를 포장하고, 
	아홉 번째 재료가 쌓였을 때, 두 번째 재료와 일곱 번째 재료부터 아홉 번째 재료를 이용하여 햄버거를 포장합니다. 
	즉, 2개의 햄버거를 포장하게 됩니다.

	상수에게 전해지는 재료의 정보를 나타내는 정수 배열 ingredient가 주어졌을 때, 
	상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.
	*/
	
    public int solution(int[] ingredient) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ingredient.length; i++) {
            sb.append(ingredient[i]);
            // 길이가 3보다 크고 마지막 4자리가 "1231"이면
            if (sb.length() > 3 && sb.substring(sb.length() - 4, sb.length()).equals("1231")) {
                answer++;
                sb.delete(sb.length() - 4, sb.length()); // sb에서 마지막 4개가 햄버거란 뜻이니까 햄버거 없애기
            }
        }

        return answer;
    }

	
	// 틀린 이유... 또 문제 제대로 파악 못 함.
	// 문제는 정확하게 맞는 것만 뽑아야 하는데 나는 그냥 맞으면 때려 넣게 작성했음
    public static int solution1(int[] ingredient) {
        int[] ingre = {1, 2, 3, 1};
        int index = 0;
        int answer = 0;

        List<Integer> hamburger = Arrays.stream(ingredient)
                .boxed()
                .collect(Collectors.toList());

        for (int i = 0; i < hamburger.size(); i++) {
            if (hamburger.get(i) == ingre[index]) {
                System.out.println("햄버거 : " + i);
                System.out.println("index : " + index);
                hamburger.remove(i);
                i--; 
                index++;

                if (index == 4) {
                    System.out.println("=== 새 햄버거 ===" + index);
                    index = 0;
                    i = 0;
                    answer++;
                }
            }
        }

        return answer;
    }
    
    public static void main(String[] args) {
    	S61_햄버거만들기 ham = new S61_햄버거만들기();
    	
    	int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
    	
    	System.out.println("answer : " + ham.solution(ingredient));
    }
    
}
