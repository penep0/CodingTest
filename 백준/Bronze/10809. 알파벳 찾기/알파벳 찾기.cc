#include <stdio.h>

void baekjoon(char *array){
  int al[26] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
  for(int i = 97; i < 123; i++){
    int n = 0;
    while(array[n] != '\0'){
      if(array[n] == i){
        al[i - 97] = n;
        break;
      }
      n++;
    }
  }
  for(int i = 0; i < 26; i++){
    printf("%d ",al[i]);
  }
}
int main(){
  char arry[100];
  scanf("%s",&arry);
  baekjoon(arry);
  return 0;
}