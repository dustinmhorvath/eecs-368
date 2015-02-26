; Dustin Horvath
; Queens.rkt
; 02/05/15
; This program uses function (test n) to determine all the solution to the 
;  queens problem for sizes 1 to n.

#lang racket

(define (accumulate op initial sequence)
  (if (null? sequence)
      initial
      (op (car sequence)
          (accumulate op initial (cdr sequence)))))

(define (map f l)
  (cond ((not (pair? l)) '())
        (else (cons ( f (car l)) (map f (cdr l))))))

(define (flatmap f l)
  (apply append (map f l)))

(define (enumerate-interval l h)
  (if (> l h)
      null
      (cons l (enumerate-interval (+ l 1) h))))

(define (square x)
  (* x x))

(define (remove x l)
  (if (equal? x (car l)) (cdr l)
      (cons (car l) (remove x (cdr l)))))


(define (iperm l a)
  (if (null? l)
      (list '())
      (flatmap (lambda (x)
                 (map (lambda (a) (cons x a))
                        (iperm (remove x l) a)))
              l)))

(define (iqueens l a)
  (if (null? l)
      (list '())
      (flatmap (lambda (x)
                 (map (lambda (a) (cons x a))
                        (if (diagonal? x a) '() (iqueens (remove x l) (cons x a)))))
              l)))

(define (diagonal? col a) (diagonal_helper? col a 1))

(define (diagonal_helper? col a increment)
  (if (null? a)
      #f
      (if (or (= (car a) (+ col increment)) (= (car a) (- col increment))) #t
          (diagonal_helper? col (cdr a) (+ 1 increment)))
      )
  )

(define (q n)
  (iqueens (enumerate-interval 1 n) '() ))

(define (test n)
  (flatmap q (enumerate-interval 1 n)   ;I tried some more convoluted solutions here with a recursion, but it just wasn't worth the trouble.
  ))

(test 10)