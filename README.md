# hystrix

간단한 hystrix 환경 세팅

아래의 경우 이용하면 된다
1. 특정 기능에 오류가 났을시 해당 기능이 복구 될 동안 호출하지 않음으로써 부하로부터 벗어나고 싶을 경우(=Circuit Open)
2. 특정 기능에 오류가 났을시 다른 기능으로 대체하고 싶을 경우(=Fallback)
3. 대체된 다른 기능을 실행 중에 원래 기능이 복구가 된다면 다시 원래 기능을 실행 시키고 싶은 경우(=Circuit Close)
