function Lecture(name, scores) {
  this.name = name;
  this.scores = scores;
}

/**
 * Lecture을 이용해서 생성된 모든 객체들은 prototype 객체에 정의된 메서드를 상속받는다.
 * 특별한 작업을 하지 않는 이상 prototype에 할당되는 객체는 최상위 객체 타입인 Object이다.
 *
 * 일반 함수는 해당 객체 또는 새로 생성된 객체를 가리키지만, Arrow function은 상위 스코프의 this를 가리킨다.
 * 따라서, Arrow function은 객체의 메서드나 생성자 함수로 사용할 수 없다.
 *
 * 아래의 경우에서 Arrow function을 사용하면 this는 Lecture 객체가 아닌 전역 객체인 window를 가리키게 된다.
 * 따라서 this.name과 this.getEvaluationMethod()는 undefined가 되어 에러가 발생한다.
 */
Lecture.prototype.stats = function () {
  return `Name: ${this.name}, Evaluation Method: ${this.getEvaluationMethod()}`;
}

Lecture.prototype.getEvaluationMethod = function () {
  return 'Pass or Fail';
}

function GradeLecture(name, canceled, scores) {
  Lecture.call(this, name, scores);
  this.canceled = canceled;
}

/**
 * Lecture 객체를 상속받는 GradeLecture 객체를 생성한다.
 * 이를 통해 GradeLecture 객체는 Lecture 객체의 모든 속성과 메서드를 상속받는다.
 */
GradeLecture.prototype = new Lecture();

GradeLecture.prototype.constructor = GradeLecture;

GradeLecture.prototype.getEvaluationMethod = function () {
  return 'Grade';
}

const gradeLecture = new GradeLecture('OOP', false, [1, 2, 3]);
console.log(gradeLecture.stats());