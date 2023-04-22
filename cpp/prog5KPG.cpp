/*
 * C++ portion of Project5
 * CSCI 265
 * Kaleb Gilson - kaleb.gilson@und.edu - 4/21/23
 */
#include <iostream>
#include <unordered_map>
#include <vector>
#include <iomanip>

using namespace std;

bool addPart(unordered_map<string, double>& parts, string part, double cost);
int totalParts(unordered_map<string, double>& parts);
vector<string> partsGreaterThan(unordered_map<string, double>& parts, double upperLimit);
bool isPart(unordered_map<string, double>& parts, string part);
string leastExpensivePart(unordered_map<string, double>& parts);
string mostExpensivePart(unordered_map<string, double>& parts);
double averagePrice(unordered_map<string, double>& parts);
void printParts(unordered_map<string, double>& parts);

int main() {
    unordered_map<string, double> parts;
    parts["Part1"] = 57.99;
    parts["Part2"] = 98.5;
    parts["Part3"] = 7.95;
    parts["Part4"] = 19.99;

    addPart(parts, "Part5", 0.01);
    addPart(parts, "Part4", 0.01);
    totalParts(parts);

    vector<string> partsAboveLimit = partsGreaterThan(parts, 0.02);

    isPart(parts, "Part5");
    isPart(parts, "Part7");
    leastExpensivePart(parts);
    mostExpensivePart(parts);
    averagePrice(parts);

    printParts(parts);

    return 0;
}

// Add a part to the parts map
bool addPart(unordered_map<string, double>& parts, string part, double cost) {
    if (parts.count(part) >= 1) {
        parts[part] = cost;
        return false;
    } else {
        parts[part] = cost;
        return true;
    }
}

// Get the total number of parts in the map
int totalParts(unordered_map<string, double>& parts) {
    return parts.size();
}

// Get the parts that are greater than the given limit
vector<string> partsGreaterThan(unordered_map<string, double>& parts, double upperLimit) {
    vector<string> partsAboveLimit;
    for (auto part : parts) {
        if (part.second >= upperLimit) {
            partsAboveLimit.push_back(part.first);
        }
    }
    return partsAboveLimit;
}

// Get if the part is in the map
bool isPart(unordered_map<string, double>& parts, string part) {
    return parts.count(part);
}

// Get the least expensive part in the map
string leastExpensivePart(unordered_map<string, double>& parts) {
    string part;
    double price = 0;
    for (auto& key : parts) {
        if (part.empty() || key.second < price) {
            part = key.first;
            price = key.second;
        }
    }
    return part;
}

// Get the most expensive part in the map
string mostExpensivePart(unordered_map<string, double>& parts) {
    string part;
    double price = 0;
    for (auto& key : parts) {
        if (part.empty() || key.second > price) {
            part = key.first;
            price = key.second;
        }
    }
    return part;
}

// Get the average price of parts in the given map
double averagePrice(unordered_map<string, double>& parts) {
    double totalPrices = 0;
    if (parts.size() == 0) return -1;
    for (auto& key : parts) {
        totalPrices += key.second;
    }
    return totalPrices / parts.size();
}

// A formatted list of parts and their prices
void printParts(unordered_map<string, double>& parts) {
    cout << left << setw(15) << "Part" << right << setw(10) << "Price" << endl;
    cout << "------------------------------" << endl;
    for (auto& p : parts) {
        cout << left << setw(15) << p.first << right << setw(10) << fixed << setprecision(2) << p.second << endl;
    }
}