#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <unordered_map>
#include <algorithm>
#include <string>

using namespace std;

vector<string> word_list;
unordered_map<string,bool> dictionary_map;

// Method to initialize the program from file
void initializeFile(){
    ifstream infile;
    infile.open("wordsforproblem.txt");
    int cnt=0;
    while (!infile.eof())
    {
        string str,temp;
        getline(infile, str);
        for (int i=0; i<str.length(); i++) {
            if(isprint(str.at(i))){
                temp+=str.at(i);
            }
        }
        word_list.push_back(temp);
    }
    infile.close();
}

// Method to check the if current word can be made from the small dictionary words
bool can_build_word(string word,bool dictionary_flag){
    if(dictionary_map.find(word)!=dictionary_map.end() && !dictionary_flag){
        return dictionary_map.find(word)->second;
    }
    for(int i=1;i<word.length();i++){
        string left=word.substr(0,i);
        string right=word.substr(i);
        if(dictionary_map.find(left)!=dictionary_map.end() && dictionary_map.find(left)->second && can_build_word(right,false)){
            return true;
        }
    }
    return false;
}


// Method to find the longest and second longest word
void get_words(){
    string first_word="";
    string second_word="";
    string current_word="";
    int word_count=0;
    for(int i=0;i<word_list.size();i++){
        //cout<<word_list[i]<<word_list[i].length()<<endl;
        dictionary_map.insert(pair<string,bool>(word_list[i],true));
    }
    for(int i=0;i<word_list.size();i++){
        current_word=word_list[i];
        if(can_build_word(current_word,true)){
            word_count++;
            if(current_word.length()>first_word.length()){
                second_word=first_word;
                first_word=current_word;
            }
            else if(current_word.length()>second_word.length()){
                second_word=first_word;
            }
        }
    }
    cout<<"\nTotal number of words which can be created form the small words : "<<word_count<<endl;
    cout<<"\nTwo longest words : "<<endl;
    cout<<"First Longest word : "<<first_word<<endl;
    cout<<"Second Longest word : "<<second_word<<endl;
}

// Method to compare the length of the strings
bool string_sort(string a, string b){
    return a.length()<b.length();
}

// Main method
int main(){
    initializeFile();
    sort(word_list.begin(),word_list.end(),string_sort);
    cout<<"Total size of the dictionary is : "<<word_list.size()<<endl;
    get_words();
}

