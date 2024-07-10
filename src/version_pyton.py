import time;
def fibonacci(n):
    if n<=1:
        return n
    return fibonacci(n-1)+fibonacci(n-2)

def fibonacciCaching(n,cache=None):
    if cache is None:
        cache =={}
        if n<=1:
            return n;
        if n in cache:
            return cache[n]
        result= fibonacciCaching(n-1,cache)+fibonacciCaching(n-2,cache)

def main():
    print("Programacion dinamica")
    star_time =time.time_ns()
    print(fibonacci(40))
    end_time = time.time_ns()
    print(f"Time taken {end_time-star_time} ns")

    star_time =time.time_ns()
    print(fibonacci(40))
    end_time = time.time_ns()
    print(f"Time taken {end_time-star_time} ns")

if __name__ == "__main__":
    main()