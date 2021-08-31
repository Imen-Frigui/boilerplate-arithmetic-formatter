def arithmetic_arranger(problems,solvethem="false"):
    if len(problems) > 5:
        return "Error: Too many problems."

    line1: str = ""
    line2: str = ""
    line3: str = ""
    line4: str = ""
  
    for i, problem in enumerate(problems):
        op1, operation, op2 = problem.split(" ")

        if operation not in ["+", "-"]:
            return "Error: Operator must be '+' or '-'."
        if len(op1) > 4 or len(op2) > 4:
            return "Error: Numbers cannot be more than four digits."
        if not op1.isdigit() or not op2.isdigit():
            return "Error: Numbers must only contain digits."

        if operation == '+':
            solution = int(op1) + int(op2)
        else:
            solution = int(op1) - int (op2)
       
        line_max_width = max([len(op1), len(op2)]) + 2
        num_blanks = line_max_width - len(op1)
        line1 = line1 + f"{' ' * num_blanks}{op1}"
        num_blanks = line_max_width - 2 - len(op2)
        line2 = line2 + f"{operation} {' ' * num_blanks}{op2}"
        line3 = line3 + f"{'-' * line_max_width}"
        
        arranged_problems= f"{line1}\n{line2}\n{line3}"


        
          
          if solvethem == True:
          line4 = line4 + str(solution).rjust(num_blanks)
          arranged_problems = arranged_problems + "\n" + line4
        if i < len(problems) - 1:  # ifnot the last problem
            line1 = line1 + f"{' ' * 4}"
            line2 = line2 + f"{' ' * 4}"
            line3 = line3 + f"{' ' * 4}"
            line4 = line4 + f"{' ' * 4}"

   
        
  
    return arranged_problems