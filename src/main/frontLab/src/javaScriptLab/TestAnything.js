let array = [ 1, 2, 3, 4, 5]
let copyArray = []

for( let i = 0; i < array.length; i++){
    copyArray.push(array[i]);
}
console.log( copyArray )

copyArray = []

for( let i in array ){
    copyArray.push(array[i])
}
console.log( copyArray )

copyArray = []

for( let i of array ){
    copyArray.push(i)
}
console.log(copyArray)

copyArray = []

array.forEach( r =>  copyArray.push(r) )
console.log(copyArray)

copyArray = []

copyArray = array.map( r => r );

console.log(copyArray)


