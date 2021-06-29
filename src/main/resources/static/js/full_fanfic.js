var $add = document.getElementsByClassName('add')[0];
var $form = document.getElementsByClassName('form')[0];
var x = 0;
$add.addEventListener('click', function(event) {

    var $input_title = document.createElement('input');
    $input_title.type = 'text';
    $input_title.placeholder = 'Заголовок';
    $input_title.classList.add('amount');
    $input_title.name = 'title';

    var $input_text = document.createElement('input');
    $input_text.type = 'text';
    $input_text.placeholder = 'Текст';
    $input_text.classList.add('amount');
    $input_text.name = 'text_of_fanfiq';
    $form.insertBefore($input_title, $add);
    $form.insertBefore($input_text, $add);
    x++
});