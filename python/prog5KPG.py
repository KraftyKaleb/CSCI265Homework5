#
# Python portion of Project5
# CSCI 265
# Kaleb Gilson - kaleb.gilson@und.edu - 4/21/23
#

# Add a part to the parts map
def addPart(parts, part, cost):
    if part in parts:
        parts[part] = cost
        return False
    else:
        parts[part] = cost
        return True


# Get the total number of parts in the map
def totalParts(parts):
    return len(parts)


# Get the parts that are greater than the given limit
def partsGreaterThan(parts, upperLimit):
    partsList = []
    for key in parts.keys():
        if parts[key] >= upperLimit:
            partsList.append(key)
    return partsList


# Get if the part is in the map
def isPart(parts, part):
    return part in parts


# Get the least expensive part in the map
def leastExpensivePart(parts):
    part = None
    price = 0
    for key in parts.keys():
        if part is None or parts[key] < price:
            part = key
            price = parts[key]
    return part


# Get the most expensive part in the map
def mostExpensivePart(parts):
    part = None
    price = 0
    for key in parts.keys():
        if part is None or parts[key] > price:
            part = key
            price = parts[key]
    return part


# Get the average price of parts in the given map
def averagePrice(parts):
    totalPrices = 0
    if len(parts) == 0:
        return -1
    for key in parts.keys():
        totalPrices += parts[key]
    return totalPrices / len(parts)


# A formatted list of parts and their prices
def printParts(parts):
    print("{:<15} {:>10}".format("Part", "Price"))
    print("------------------------------")
    for key in parts.keys():
        print("{:<15} {:>10.2f}".format(key, parts[key]))


# Main
parts = {}
parts["Part1"] = 57.99
parts["Part2"] = 98.5
parts["Part3"] = 7.95
parts["Part4"] = 19.99

print(addPart(parts, "Part5", 0.01))
print(addPart(parts, "Part4", 0.01))
print(totalParts(parts))
print(partsGreaterThan(parts, 0.02))
print(isPart(parts, "Part5"))
print(isPart(parts, "Part7"))
print(leastExpensivePart(parts))
print(mostExpensivePart(parts))
print(averagePrice(parts))

printParts(parts)
