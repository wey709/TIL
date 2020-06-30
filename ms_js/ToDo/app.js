let input = document.getElementById("input")
let addBtn = document.getElementById("add")
let clearBtn = document.getElementById("clear")
let taskList = document.getElementById("taskList")

addBtn.addEventListener("click", addList)
clearBtn.addEventListener("click",clearInput)


function addList(){
    let inputVal = document.getElementById("task").value

    if(inputVal.length==0){
        window.alert("check again")
    }
    else{
        let newList = document.createElement('li')
        let text = document.createTextNode(inputVal)
        newList.appendChild(text)
        taskList.appendChild(newList)
    }

}

function clearInput(){
    let inputVal = document.getElementById("task").value
    inputVal = ""
}
