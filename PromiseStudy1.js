/*
Promise : "지금은 없는데 이상없으면 이따가 주고 없으면 알려줄게~"

Promise 상태
- pending : 아직 약속을 수행 중인 상태(fulfilled 혹은 reject가 되기 전)
- fulfilled : 약속(promise)이 지켜진 상태
- rejected : 약속이 어떤 이유에서 못 지켜진 상태
- settled : 약속이 지켜졌든 안지켜졌든 일단 결론이 난 상태이다.
*/

//Promise 선언
var _promise = function (param) {
    return new Promise (function (resolve, reject) {

        window.setTimeout(function() {

            //파라메터가 참이면,
            if (param) {

                //해결됨
                resolve("해결 완료");
            }

            //파라메터가 거짓이면,
            else {
                
                //실패
                reject(Error("실패!!"));
            }
        }, 3000);
    });
};


//Promise 실행
_promise(true)
.then(function (text) {
    //성공시
    console.log(text);
}, function (error) {
    //실패시
    console.error(error);
});