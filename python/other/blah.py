def main():
    result = mystery(5)
    print(result)
         
def mystery(n):
    if n <= 1:
        return 1
    else:
        return 2 * mystery(n - 1)
                                         
main()
