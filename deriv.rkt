#lang racket

(define (deriv v Z)
  (if (not (pair? Z))
      (cond ((number? Z) 0)
            ((eq? v Z) 1) (else 0))
  (case (car Z)
    ((+) (list ('+) (deriv v (cadr Z)) (deriv v (cons ('+) (caddr Z)))))
    
    
    
    (else (deriv v (car Z))))))

(deriv 'x (+ 7 8 5))