// Event listener for Cadastrar Turma form
document.getElementById('turmaForm').addEventListener('submit', async function(event) {
    event.preventDefault();
    const nomeTurma = document.getElementById('nomeTurma').value;

    // Register Turma
    await fetch(`http://localhost:8080/recicle/cadastrar/turma?nomeTurma=${nomeTurma}`, {
        method: 'POST'
    }).finally(
        console.log(event)
    );

    // Consultar todas as Turmas
    const consultaTodasTurmas = await fetch('http://localhost:8080/recicle/consulta');
    const todasTurmasData = await consultaTodasTurmas.json();

    // Display results
    document.getElementById('turmaResults').innerHTML = `
        <h3>Consulta Todas as Turmas</h3>
        <pre>${JSON.stringify(todasTurmasData, null, 2)}</pre>
    `;
});

// Event listener for Cadastrar Objetos form
document.getElementById('objetosForm').addEventListener('submit', async function(event) {
    event.preventDefault();
    const nomeObjeto = document.getElementById('nomeObjeto').value;
    const tipoObjeto = document.getElementById('tipoObjeto').value;
    const quantidadeObjeto = document.getElementById('quantidadeObjeto').value;
    const turmaId = document.getElementById('turmaId').value;

    // Register Objetos
    await fetch(`http://localhost:8080/recicle/cadastrar/objetos?nome=${nomeObjeto}&tipo=${tipoObjeto}&quantidade=${quantidadeObjeto}&turma_id=${turmaId}`, {
        method: 'POST'
    });

    // Consultar Turma by ID
    const consultaTurma = await fetch(`http://localhost:8080/recicle/consulta/${turmaId}`);
    console.log(consultaTurma);
    const turmaData = await consultaTurma.json();
    console.log(turmaData);

    // Display results
    document.getElementById('objetosResults').innerHTML = `
        <h3>Consulta Turma ID: ${turmaId}</h3>
        <pre>${JSON.stringify(turmaData, null, 2)}</pre>
    `;
});

// Event listener for Consultar Turma form
document.getElementById('consultaTurmaForm').addEventListener('submit', async function(event) {
    event.preventDefault();
    const turmaId = document.getElementById('consultaTurmaId').value;

    // Consultar Turma by ID
    const consultaTurma = await fetch(`http://localhost:8080/recicle/consulta/${turmaId}`);
    console.log(consultaTurma);
    const turmaData = await consultaTurma.json();
    console.log(turmaData);

    // Display results
    document.getElementById('consultaTurmaResults').innerHTML = `
        <h3>Consulta Turma ID: ${turmaId}</h3>
        <pre>${JSON.stringify(turmaData, null, 2)}</pre>
    `;
});

// Event listener for Consultar Objetos button
document.getElementById('consultarObjetosBtn').addEventListener('click', async function() {
    // Consultar todas as Turmas
    const consultaTodasTurmas = await fetch('http://localhost:8080/recicle/consulta');
    const todasTurmasData = await consultaTodasTurmas.json();

    // Display results
    document.getElementById('consultaObjetosResults').innerHTML = `
        <h3>Consulta Todos os Objetos</h3>
        <pre>${JSON.stringify(todasTurmasData, null, 2)}</pre>
    `;
});
