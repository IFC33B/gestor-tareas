export interface Tasca {
    id: number;
    titol: string;
    descripcio: string;
    feta: boolean;
}

export interface TascaRequest {
    titol: string;
    descripcio: string;
    feta: boolean;
}