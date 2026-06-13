// 문제 설명

// 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
// 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
// 구조대 : 119
// 박준영 : 97 674 223
// 지영석 : 11 9552 4421
// 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
// 제한 사항
// phone_book의 길이는 1 이상 1,000,000 이하입니다.
// 각 전화번호의 길이는 1 이상 20 이하입니다.
// 같은 전화번호가 중복해서 들어있지 않습니다.
// 입출력 예제
// phone_book	return
// ["119", "97674223", "1195524421"]	false
// ["123","456","789"]	true
// ["12","123","1235","567","88"]	false
// 입출력 예 설명
// 입출력 예 #1
// 앞에서 설명한 예와 같습니다.
// 입출력 예 #2
// 한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.
// 입출력 예 #3
// 첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.

//알고리즘 : 해시맵에 전체 번호를 넣은 후, 하나의 번호를 꺼내서 그 번호의 접두어가 해시맵에 존재하는지 확인한다. 존재한다면 false를 반환하고, 존재하지 않는다면 다음 번호로 넘어간다. 모든 번호에 대해서 확인이 끝나면 true를 반환한다. 

import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();
        
        // 1. 모든 전화번호를 HashMap에 저장 (조회 속도를 O(1)로 만들기 위함)
        for (String number : phone_book) {
            map.put(number, 1);
        }
        
        // 2. 각 전화번호의 접두어가 HashMap에 존재하는지 확인
        for (String number : phone_book) {
            // 본인 자신을 제외한 모든 접두어 길이를 체크 (길이 1부터 본인 길이 - 1까지)
            for (int j = 1; j < number.length(); j++) {
                String prefix = number.substring(0, j);
                if (map.containsKey(prefix)) {
                    return false; // 내 앞부분이 다른 사람의 완성된 번호라면 false
                }
            }
        }
        
        return true;
    }
}