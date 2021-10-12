# 2021.10.05.화

### 백준 18442 우체국 1 (실버 2) 문제 풀이

![](https://github.com/Doppio1101/BAEKJOON_TIL/blob/master/week13/day1005/BJ18442.PNG?raw=true)

- 시험과 같은 환경일거라고 생각한 큰 오류...
- 런타임 에러의 원인은 Long타입을 int로 받아오기때문에 생기는 오류였다.
- 이를 해결하고도 틀렸던 이유는 long을 int로 형변환을 하면서 생기는 문제였던 것 같다.



#### 우체국 2를 풀기 위한 빌드업.

- 시험에서는 V의 제한이 100까지였기 때문에 지금과 같은 방식으로 풀면 시간초과가 나올 가능성이 매우 높다.
- 조합에서 가장 큰 값이 나오는 경우는 nC(n/2)이므로 V가 100이고 설치해야 하는 우체국 P가 50이 되면 가장 큰 수가 나오는데 DP로 풀어도 안 될 거 같다는 판단이 된다.



#### 문제 풀이

- 처음 접근을 했을 때는 V*V 2차원 배열을 만든 후 풀고자 했었는데 타입오류로 바꾸다보니 2차원 배열을 지웠다.

- V의 최대 값은 20이기 때문에 1초(1억 연산)에서 400번 정도의 시간 분할은 괜찮을 것 같다고 판단되었다.

- 또, 20C10이 최대 경우의 수이기 때문에 일반적인 조합 방식을 이용해도 문제 없을 것 같다고 판단하여

  ``` java
  private static void combi(int cnt, int idx) {// cnt는 뽑은 개수, idx는 시작하는 위치
  		if (cnt == P) {// 기저조건!
  			// 뭔가를 할 예정.
  //			System.out.println(Arrays.toString(post));
  			play();
  			return;
  		}
  		for (int i = idx; i < V; i++) {
  			extra[cnt] = local[i];
  			combi(cnt + 1, i + 1);
  		}
  
  }
  ```

- 이와 같이 extra라는 임시 배열에 local(마을의 위치) 배열에서 하나 하나 넣어주며 play라는 함수로 넘겼다.
- 다시 짚어보면 우체국 2는 V의 최대가 100이기 때문에 이같은 방법은 사용할 수 없다.

``` java
private static void play() {
		long sum = 0;
		for (int i = 0; i < V; i++) {
			long semi = Long.MAX_VALUE;
			for (int j = 0; j < P; j++) {
				
				semi = Math.min(semi, Math.min(Math.abs(local[i] - extra[j]), L - Math.abs(local[i] - extra[j])));
				
			}
			sum += semi;
		}
		if (min > sum) {
			min = sum;
			for (int i = 0; i < P; i++) {
				post[i] = extra[i];
			}
		}

}
```

- semi = Math.min(semi, Math.min(Math.abs(local[i] - extra[j]), L - Math.abs(local[i] - extra[j])));으로
- local[i]번째의 마을에서 임의로 뽑은 extra[j] 번째의 거리를 주어진 식(좌표가 x, y인 두 마을의 거리는 min(|x - y|, L - |x - y|) 이다. )으로 계산을 하고 이 거리와 원래 저장 된 작은 값 중 제일 작은 값을 semi에 저장한다.
- 이때, 같은 마을이라면 0이 저장되면서 semi에 0이 들어가게 되어 따로 처리해주지 않아도 됐다.
- 이렇게 구해진 semi를 sum에 더해 sum이 min보다 작을 때마다 출력할 post배열을 extra의 값으로 갱신해주었다.